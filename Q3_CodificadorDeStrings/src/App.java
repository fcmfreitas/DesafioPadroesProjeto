public class App {
    public static void main(String[] args) throws Exception {

        Codificador codificadorBasico = new Codificador();
        CodificadorComLog codificadorComLog = new CodificadorComLog(codificadorBasico);
        String aux = "Desafio Padrões de Projeto";

        System.out.println("Texto original: " + aux);
        aux = codificadorComLog.codifica(Codificador.Tipo.SIMPLES, aux);
        System.out.println("Codificado (SIMPLES): " + aux);
        aux = codificadorComLog.deCodifica(Codificador.Tipo.SIMPLES, aux);
        System.out.println("Decodificado (SIMPLES): " + aux);
        aux = codificadorComLog.codifica(Codificador.Tipo.DESLOCA, aux);
        System.out.println("Codificado (DESLOCA): " + aux);
        aux = codificadorComLog.deCodifica(Codificador.Tipo.DESLOCA, aux);
        System.out.println("Decodificado (DESLOCA): " + aux);

        CodificadorComLogDetalhado codificadorComLogDetalhado = new CodificadorComLogDetalhado(codificadorBasico);

        aux = "Outro exemplo com log detalhado";
        System.out.println("Texto original: " + aux);
        
        aux = codificadorComLogDetalhado.codifica(Codificador.Tipo.SIMPLES, aux);
        System.out.println("Codificado (SIMPLES): " + aux);
        
        aux = codificadorComLogDetalhado.deCodifica(Codificador.Tipo.SIMPLES, aux);
        System.out.println("Decodificado (SIMPLES): " + aux);
    }
}
