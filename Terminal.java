import java.util.Scanner;

public class Terminal {
    public static final Scanner SC = new Scanner(System.in);

    public static void adcionarCores(String[] vetorCores){
        String cor;

        for(int i=0; i< vetorCores.length; i++){
            System.out.print((i+1)+"° Cor: ");
            cor = SC.nextLine();

            while(cor.length()<3 || !cor.matches("^[a-zA-Z]+$")){
                System.out.print("Nome invalido|Escreva novamente: ");
                cor = SC.nextLine();
            }

            boolean corRepetida = false;

            for (int j=0; j<i; j++) {
                if (cor.equalsIgnoreCase(vetorCores[j])) {
                    System.out.print("Nome repetido!!!\n");
                    corRepetida = true;
                    break;
                }
            }

            if (corRepetida){
                i--;
            }else{
                vetorCores[i] = cor;
            }
        }
    }

    public static void adcionarTempo(String[] vetorCores, int[]  vetorTempos){
        String tempoBruto;
        int tempo = 0;
        boolean invalido = true;

        for(int i=0; i< vetorCores.length; i++){
            do{
                try{
                    System.out.print("Escreva o tempo da cor " + vetorCores[i] + ": ");
                    tempoBruto = SC.nextLine();
                    tempo = Integer.parseInt(tempoBruto);

                    while(tempo<=0){
                        System.out.print("Nao voltamos no tempo|Escreva o tempo da cor "  + vetorCores[i] + ":") ;
                        tempoBruto = SC.nextLine();
                        tempo = Integer.parseInt(tempoBruto);
                    }

                    invalido = false;

                }catch(NumberFormatException ex){
                    System.out.print("Apenas numeros|");
                    invalido = true;
                }
            }while(invalido);

            vetorTempos[i] = tempo;
        }
    }

    public static boolean lerBoleano(String label){
        System.out.print(label);

        String verdadeiroFalso = SC.nextLine();


        while(!verdadeiroFalso.equalsIgnoreCase("s") && !verdadeiroFalso.equalsIgnoreCase("n")){
            System.out.print("Apenas [S|N]: ");
            verdadeiroFalso = SC.nextLine();

        }

        if(verdadeiroFalso.equalsIgnoreCase("S")){
            return true;
        }else{
            return false;
        }
    }

    public static int escolherAlerta(String[] vetorCores){
        System.out.println("Escolha a cor do alerta!!!");

        for(int i=0; i< vetorCores.length; i++){
            System.out.println((i+1) + " - " + vetorCores[i]);
        }

        int corEscolhida;
        corEscolhida = SC.nextInt();
        SC.nextLine();

        while(corEscolhida<0 || corEscolhida>vetorCores.length){
            System.out.print("Escolha um numero correspondente a cor: ");
            corEscolhida = SC.nextInt();
            SC.nextLine();
        }

        return corEscolhida-1;
    }

    public static int ciclosAlertaControle(String label){
        int ciclosInt = 0;
        String ciclosBrutos;
        boolean invalido = true;

        do{
            try{
                System.out.print(label);
                ciclosBrutos = SC.nextLine();
                ciclosInt = Integer.parseInt(ciclosBrutos);


                while(ciclosInt<=0){
                    System.out.print("Nao voltamos no tempo|" + label + ": ") ;
                    ciclosBrutos = SC.nextLine();
                    ciclosInt = Integer.parseInt(ciclosBrutos);
                }

                invalido = false;

            }catch(NumberFormatException ex){
                System.out.print("Apenas numeros: ");
            }

        }while(invalido);

        return ciclosInt;

    }
}