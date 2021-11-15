package pt.goncalo.joshlong.reactivespring.files;

import lombok.extern.log4j.Log4j2;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;

import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.util.function.Consumer;

@Log4j2
public class AsynchronousFileReader implements CompletionHandler<Integer, ByteBuffer> {

    int bytesRead = 0;
    int position = 0;



    public void read(File f, Consumer<Byte> bytesConsumer, Runnable finished) throws IOException {
        var p = f.toPath();
        var fileChannel = AsynchronousFileChannel.open(p);
        ByteBuffer buffer = ByteBuffer.allocate(FileCopyUtils.BUFFER_SIZE);
        fileChannel.read(buffer, 0, buffer, this);
        log.info("bytes read" + bytesRead);
        while(this.bytesRead > 0){
            log.info("bytes read");
            this.position += this.bytesRead;
            fileChannel.read(buffer, position, buffer, this);
        }

    }

    @Override
    public void completed(Integer result, ByteBuffer buffer) {
        this.bytesRead = result;
        if (result < 0) {
            log.info("EOF reached. I'm done reading!");
            return;
        }

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);

        log.info("Received buffer");
        buffer.clear();
        this.position += bytesRead;
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        log.error(exc);
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        log.info("Program started");
        new AsynchronousFileReader().read(Paths.get("/Users/CTW00977-Admin/","logs.txt").toFile(),
                aByte -> log.info("consumer got: " + aByte),null);
        while(true){
            Thread.sleep(1000);
        }

    }
}
