public class SemaforoController {
    public static void semaforo(){
        String [] cores = new String[3];
        int [] tempo = new int[3];

        Terminal.adcionarCores(cores);
        Terminal.adcionarTempo(cores, tempo);

        int corAlerta = Terminal.escolherAlerta(cores);
        int tempoAlerta = tempo[corAlerta];
        int ciclosEntrada = Terminal.ciclosAlertaControle("Quantos ciclos entrara no alerta: ");
        int ciclosSaida = Terminal.ciclosAlertaControle("Quantos ciclos saira do alerta: ");

        boolean continuarSemaforo = Terminal.lerBoleano("Deseja iniciar o Semaforo [S|N]: ");

        if(!continuarSemaforo){
            System.out.println("\nThankiu");

        }else{
            SemaforoService.controleSemafaro(cores, tempo, corAlerta, tempoAlerta, ciclosEntrada, ciclosSaida);
        }
    }
}