package beginner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Estadio {
    /**
     * Verifica se a pressao está acima de 1 BAR
     * @param bolas
     */
    public boolean verificarBolas(List<Bola> bolas){
        //verificar se a pressao está acima de 1.0
        for(int i = 0; i < bolas.size() ; i++ ){
            Bola bola = bolas.get(i);
            if(bola.getPressao() <  1.0){
                return false;
            }
        }



        return true;


    }

    public void jogar(List<Bola> bolas, List<String> equipa1, List<String> equipa2, List<String> arbitros) {




    }

    public static void main(String[] args) {
        Bola um = new Bola();
        Bola dois = new Bola();
        Bola tres = new Bola();

        List<Bola> bolas = new ArrayList<>();
        bolas.add(um);
        bolas.add(dois);
        bolas.add(tres);
        Estadio luz = new Estadio();
        luz.verificarBolas(bolas);
        luz.jogar(bolas, null, null, null);
    }
}
