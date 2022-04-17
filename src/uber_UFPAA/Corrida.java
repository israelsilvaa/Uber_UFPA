package uber_UFPAA;
//importação para entradad de dados 
import java.util.Scanner;
public class Corrida {
    
    protected Facade f;
    private int op = 10;
    
    //coordenadas de localização atual e de destino na matriz.
    private int linhaA=1, colunaA = 21;
    private int linhaD=6, colunaD =28;
    
   //criação da matriz, tamanho
    private final int linha = 15;
    private final int coluna = 30;
    //----------
    
    String mat[][] = new String[linha][coluna];
   Scanner entrada = new Scanner(System.in);

    public void moviBasicos(int linhaDest, int colunaDest, Facade f) throws InterruptedException{
        //acções basicas e faceis
        //quando apenas precisa subir
        if((linhaA > linhaDest)&&(colunaA == colunaDest)){
            while(linhaA != linhaDest){
                this.subir(f);
            }
        //quando apenas precisa descer    
        }else if((linhaA < linhaDest)&&(colunaA == colunaDest)){
            while(linhaA != linhaDest){
                this.descer(f);
            }
        //quando apenas precisa ir p esquerda 
        }else if((linhaA ==  linhaDest)&&(colunaA > colunaDest)){
            while(colunaA != colunaDest){
                this.esquerda(f);
            }
        //quando apenas precisa ir p direita
        }else if((linhaA == linhaDest)&&(colunaA < colunaDest)){
            while(colunaA != colunaDest){
                this.direita(f);
            }
        }
    }
    //faz a mivimentação ate que a localização atual seja igual ao destino
    public void ir(int linhaDest, int colunaDest, Facade f) throws InterruptedException{
        
        //caso o destino seja alcançado apenas com movimentos em uma direção, essa função ja resolve o caso
        //e o WHILE abaixo não é executado
        this.moviBasicos(linhaDest, colunaDest, f);
       
        while((linhaA != linhaDest)&&(colunaA != colunaDest)){
            //            inicio A-1
            //Faz os movimentos de direita ou subir, caso seja necessario
            if ((linhaA > linhaDest)&&(colunaA < colunaDest)){
                if ( (("|  ".equals(mat[linhaA][colunaA+1]))||("-  ".equals(mat[linhaA][colunaA+1]))) && ((colunaA+1) <= colunaDest) ){
                    this.direita(f);
                }else if((("-  ".equals(mat[linhaA-1][colunaA])) || ("|  ".equals(mat[linhaA-1][colunaA]))) &&(linhaA-1) >= linhaDest){
                    this.subir(f);
                }
            }//           fim A-1
            
            //                                               Inicio A-2
            //Faz os movimentos de esquerda ou descer, caso seja necessario
            if ((linhaA < linhaDest)&&(colunaA > colunaDest)){
                if ( (("|  ".equals(mat[linhaA+1][colunaA]))||("-  ".equals(mat[linhaA+1][colunaA]))) && ((linhaA+1) <= linhaDest) ){
                    this.descer(f);
                }else if((("-  ".equals(mat[linhaA][colunaA-1])) || ("|  ".equals(mat[linhaA][colunaA-1]))) &&(colunaA-1) >= colunaDest){
                    this.esquerda(f);
                }
            }//                                              FIM A-2
            
            //                       Inicio A-3
            //Faz os movimentos de descer ou direita, caso seja necessario
            if ((linhaA < linhaDest)&&(colunaA < colunaDest)){
                if ( (("|  ".equals(mat[linhaA+1][colunaA]))||("-  ".equals(mat[linhaA+1][colunaA]))) && ((linhaA+1) <= linhaDest) ){
                    this.descer(f);
                }else if((("-  ".equals(mat[linhaA][colunaA+1])) || ("|  ".equals(mat[linhaA][colunaA+1]))) &&(colunaA+1)<= colunaDest){
                    this.direita(f);
                }
            }//                     FIM A-3
            
            //                                             Inicio A-4
            //Faz os movimentos de esquerda ou subir, caso seja necessario
            if ((linhaA > linhaDest)&&(colunaA > colunaDest)){
                if ( (("|  ".equals(mat[linhaA][colunaA-1]))||("-  ".equals(mat[linhaA][colunaA-1]))) && ((colunaA-1) >= linhaDest) ){
                    this.esquerda(f);
                }else if((("-  ".equals(mat[linhaA-1][colunaA])) || ("|  ".equals(mat[linhaA-1][colunaA]))) &&(linhaA-1) >= linhaDest){
                    this.subir(f);
                }
            }//                                           FIM A-4
            
            this.moviBasicos(linhaDest, colunaDest, f);
         }
        
    }//fIM METODO *******IR********
    
    public void direita(Facade f) throws InterruptedException{
        this.limpatela();
        this.lugaresRuas();
        this.setColunaA(colunaA+1);
        mat[this.getLinhaA()][this.getColunaA()] = "x ";
        this.matriz();
        this.menuLugares();
        f.getC().setTaximetro(f.getC().getTaximetro()+0.3);
        Thread.sleep(400);
    }
    public void esquerda(Facade f) throws InterruptedException{
        this.limpatela();
        this.lugaresRuas();
        this.setColunaA(colunaA-1);
        mat[this.getLinhaA()][this.getColunaA()] = "x ";
        this.matriz();
        this.menuLugares();
        f.getC().setTaximetro(f.getC().getTaximetro()+0.3);
        Thread.sleep(400);
    }
    public void subir(Facade f) throws InterruptedException{
        this.limpatela();
        this.lugaresRuas();
        this.setLinhaA(this.getLinhaA()-1);
        mat[this.getLinhaA()][this.getColunaA()] = "x ";
        this.matriz();
        this.menuLugares();
        f.getC().setTaximetro(f.getC().getTaximetro()+0.3);
        Thread.sleep(400);     
    }
    public void descer(Facade f) throws InterruptedException{
        this.limpatela();
        this.lugaresRuas();
        this.setLinhaA(linhaA+1);
        mat[this.getLinhaA()][this.getColunaA()] = "x ";
        this.matriz();
        this.menuLugares();
        f.getC().setTaximetro(f.getC().getTaximetro()+0.3);
        Thread.sleep(400);
    }
   public void criar(){
        for (int i = 0; i < linha;i++) {
            for (int j = 0; j < coluna;j++) {
                mat[i][j] = ".  ";
            }
        }
        this.lugaresRuas();
        mat[linhaA][colunaA]= "X  ";
        //inserindo os lugares na matriz
        mat[14][2] = "R U";
        mat[14][9] = "Mirante ";
        mat[12][13] = "Reit ";
        mat[6][8] = "ICEN";
        mat[0][12] = "Prt2 ";
        mat[6][29] = "PROF ";
        mat[0][20] = "Term. ";
        
    }
   
    public void lugaresRuas(){
  
        //inserindo RUAS NA HORIZONTAL da matriz
        //RU -> Mirante
        for (int i=3; i < 13;i++){
            mat[13][i] = "-  ";
        }
        //rua ICEN -> PROF
        for (int i=13; i < 29;i++){
            mat[6][i] = "-  ";
        }
        
        for (int i=12; i < 21;i++){
            mat[1][i] = "-  ";
        }
        
        
        //inserindo RUAS NA DIAGONAL da matriz
        //P2 -> Mirante
        for (int i=1; i < 14;i++){
            mat[i][12] = "|  ";
        }
        //Terminal
        for (int i=1; i < 7;i++){
            mat[i][21] = "|  ";
        }    
   } 
   
   public void matriz(){
       for (int i=0;i<linha;i++) {
            System.out.print("\n ");
            for (int j=0;j<coluna;j++) {
                System.out.print(mat[i][j]);
            }
        }
       System.out.println("\n ");
    }
    
    public void limpatela(){
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
    }
    
    public void cadastroPassageiro(Facade f){
        System.out.println("Ola bem vindo!");
        System.out.print("Qual o seu mone, passageiro?");
        f.getP().setNome_passageiro(entrada.next());
        System.out.print("E qual seu saldo(maior que R$10)?");
        f.getP().setSaldoPassageiro(entrada.nextDouble());
    } 
    
    public void menuLugares(){
        System.out.println("(1)Mirante      (2)R U        (3)Reitoria           (4)ICEN");
        System.out.println("(5)Portão dois  (6)Terminal   (7)Setor Profissional (0)SAIR");
        System.out.print("Escolha o seu destino:");
    }
    
    public void avaliação(Facade f){
        System.out.println("Total a pagar:"+"R$"+f.getC().getTaximetro());
        System.out.print("Avalie o Motorista(nota de 1 a 5):");
        f.getM().setReputção( (f.getM().getReputção()+entrada.nextDouble()) / f.getM().getNumCorridas() );
        f.getP().setSaldoPassageiro(f.getP().getSaldoPassageiro()- f.getC().getTaximetro());
    }
    
    
    public void corrida(Facade f) throws InterruptedException{
        this.cadastroPassageiro(f);
        
        while (op != 0){
            this.matriz();
            this.status(f);
            if (f.getP().getSaldoPassageiro() <= 10){
                System.out.println("-----!!!!-----Seu saldo está baixo, que tal voltar outra hora? :) -----!!!!-----");
                op = 0;
            }
            
            //o switch case abaixo condigura o destino do passageiro de acordo com a escolha 
            this.menuLugares();
            op = entrada.nextInt();
            switch (op) {
                case 1:
                    
                    //se o saldo estiver baixo, a viagem não sera realizada
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{
                        
                        //caso contrario, o destino e setado, chamamos a função de locomoção e a cada movomento dentro
                        // da finção "IR", temos a tela atualizada
                        linhaD = 13;
                        colunaD = 11;
                        this.ir(linhaD, colunaD, f);
                        this.matriz();
                        
                        //apos o final dos movimentos, a corrida é contabilizada, e é iniciada a função de "avaliação", onde
                        // tambem é foito pagamando automatico do saldo do cliente de acordo com o taximetro.
                        f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                        this.avaliação(f);
                        f.getC().setTaximetro(0);
                        break;
                    }
                case 2:
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{ 
                    linhaD = 13;
                    colunaD = 3;
                    this.ir(linhaD, colunaD, f);
                    this.matriz();
                    f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                    this.avaliação(f);
                    f.getC().setTaximetro(0);
                    break;
                    }
                case 3:
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{
                    linhaD = 12;
                    colunaD = 12;
                    this.ir(linhaD, colunaD, f);
                    this.matriz();
                    f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                    this.avaliação(f);
                    f.getC().setTaximetro(0);
                    break;
                    }
                case 4:
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{
                    linhaD = 6;
                    colunaD = 12;
                    this.ir(linhaD, colunaD, f);
                    this.matriz();
                    f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                    this.avaliação(f);
                    f.getC().setTaximetro(0);
                    break;
                    }
                case 5:
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{
                    linhaD = 1;
                    colunaD = 12;
                    this.ir(linhaD, colunaD, f);
                    this.matriz();
                    f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                    this.avaliação(f);
                    f.getC().setTaximetro(0);
                    break;
                    }
                case 6:
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{
                    linhaD = 1;
                    colunaD = 21;
                    this.ir(linhaD, colunaD, f);
                    this.matriz();
                    f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                    this.avaliação(f);
                    f.getC().setTaximetro(0);
                    break;
                    }
                case 7:
                    if (f.getP().getSaldoPassageiro() <= 10){
                        break;
                    }else{
                    this.limpatela();
                    linhaD = 6;
                    colunaD = 28;
                    this.ir(linhaD, colunaD, f);
                    this.matriz();
                    f.getM().setNumCorridas(f.getM().getNumCorridas()+1);
                    this.avaliação(f);
                    f.getC().setTaximetro(0);
                    break;
                    }
                case 0:
                    break;
                    
                default:
                    break;
            }
        }
    }  

    public int getLinhaA() {
        return linhaA;
    }

    public void setLinhaA(int linhaA) {
        this.linhaA = linhaA;
    }

    public int getColunaA() {
        return colunaA;
    }

    public void setColunaA(int colunaA) {
        this.colunaA = colunaA;
    }

    public int getLinhaD() {
        return linhaD;
    }

    public void setLinhaD(int linhaD) {
        this.linhaD = linhaD;
    }

    public int getColunaD() {
        return colunaD;
    }

    public void setColunaD(int colunaD) {
        this.colunaD = colunaD;
    }

    //informa na tela informações sopbre o carro, motorista e passageiro
    public void status(Facade f) {
        System.out.println("-------------Informações da Corrida-------------------");
        System.out.println("Motorista:"+f.getM().getNome_motorista()+"  Reputação:"+f.getM().getReputção()
                +" Mod. Carro:"+f.getC().getModelo()+"  Placa:"+f.getC().getPlaca()+"  Cor:"+f.getC().getCor_do_carro());
        System.out.println("Passageiro:"+f.getP().getNome_passageiro()+"                Seu Saldo:"
                +f.getP().getSaldoPassageiro());
        System.out.println("----------------------------------------------------------");
    }
}
