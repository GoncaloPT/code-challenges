package pt.goncalo.module;

import java.util.List;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.stream.Collectors;

public class DummyServiceConsumer {
    public void tryOut(){
        ServiceLoader.load(DummyService.class);
        DummyService service = ServiceLoader.load(DummyService.class).iterator().next();

        ServiceLoader<DummyService> serviceLoader = ServiceLoader.load(DummyService.class);
        List<ServiceLoader.Provider<DummyService>> serviceLoaders = ServiceLoader.load(DummyService.class)
                .stream()
                .collect(Collectors.toList());




        List providers2 = ServiceLoader.load(DummyService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(Collectors.toList());
    }
}
