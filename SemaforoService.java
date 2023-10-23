public class SemaforoService{
    public static void controleSemafaro(String[] vetorCores, int[]  vetorTempos, int alertaCor, int alertaTempo, int entrarCiclos, int ciclosSaida){

        while(true){
            for(int i=0; i<entrarCiclos; i++){

                for(int j=0; j<3; j++){
                    System.out.print(vetorCores[j] + "\n");
                    try{
                        Thread.sleep(vetorTempos[j]*1000L);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }

            System.out.println("ALERTA!!!\n");

            for(int ij=0; ij<ciclosSaida; ij++){
                System.out.println(vetorCores[alertaCor]);
                try {
                    Thread.sleep(alertaTempo* 1000L);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }
            System.out.println("\n");
        }
    }
}
