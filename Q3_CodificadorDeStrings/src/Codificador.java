import java.util.HashMap;
import java.util.Map;

public class Codificador {
    public enum Tipo {SIMPLES, DESLOCA};
    private Map<Character, Character> tabCod;
    private Map<Character, Character> tabDeCod;

    public Codificador() {
        tabCod = new HashMap<>();
        tabCod.put('a', '@');
        tabCod.put('e', '#');
        tabCod.put('i', '!');
        tabCod.put('o', '$');
        tabCod.put('u', '%');
        tabDeCod = new HashMap<>();
        tabDeCod.put('@', 'a');
        tabDeCod.put('#', 'e');
        tabDeCod.put('!', 'i');
        tabDeCod.put('$', 'o');
        tabDeCod.put('%', 'u');
    }

    public String codifica(Tipo tipo, String str) {
        switch (tipo) {
            case SIMPLES:
                return codificaSimples(str);
            case DESLOCA:
                return codificaDesloca(str);
            default:
                return str;
        }
    }

    public String deCodifica(Tipo tipo, String str) {
        switch (tipo) {
            case SIMPLES:
                return deCodificaSimples(str);
            case DESLOCA:
                return deCodificaDesloca(str);
            default:
                return str;
        }
    }

    private String codificaSimples(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for (int i = 0; i < aux.length; i++) {
            if (tabCod.containsKey(aux[i])) {
                resp[i] = tabCod.get(aux[i]);
            } else {
                resp[i] = aux[i];
            }
        }
        return new String(resp);
    }

    private String deCodificaSimples(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for (int i = 0; i < aux.length; i++) {
            if (tabDeCod.containsKey(aux[i])) {
                resp[i] = tabDeCod.get(aux[i]);
            } else {
                resp[i] = aux[i];
            }
        }
        return new String(resp);
    }

    private String codificaDesloca(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for (int i = 0; i < aux.length; i++) {
            resp[i] = (char) (aux[i] + 1);
        }
        return new String(resp);
    }

    private String deCodificaDesloca(String str) {
        char[] aux = str.toCharArray();
        char[] resp = new char[str.length()];
        for (int i = 0; i < aux.length; i++) {
            resp[i] = (char) (aux[i] - 1);
        }
        return new String(resp);
    }
}

interface CodificadorDecorator {
    String codifica(Codificador.Tipo tipo, String str);
    String deCodifica(Codificador.Tipo tipo, String str);
}

class CodificadorComLog implements CodificadorDecorator {
    private Codificador codificador;

    public CodificadorComLog(Codificador codificador) {
        this.codificador = codificador;
    }

    @Override
    public String codifica(Codificador.Tipo tipo, String str) {
        String resultado = codificador.codifica(tipo, str);
        log("Codificando", tipo, str, resultado);
        return resultado;
    }

    @Override
    public String deCodifica(Codificador.Tipo tipo, String str) {
        String resultado = codificador.deCodifica(tipo, str);
        log("Decodificando", tipo, str, resultado);
        return resultado;
    }

    private void log(String operacao, Codificador.Tipo tipo, String entrada, String saida) {
        System.out.println("[" + operacao + "] Tipo: " + tipo + " | Entrada: " + entrada + " | Saída: " + saida);
    }
}

class CodificadorComLogDetalhado extends CodificadorComLog {

    public CodificadorComLogDetalhado(Codificador codificador) {
        super(codificador);
    }

    @Override
    public String codifica(Codificador.Tipo tipo, String str) {
        String resultado = super.codifica(tipo, str);
        return resultado;
    }

    @Override
    public String deCodifica(Codificador.Tipo tipo, String str) {
        String resultado = super.deCodifica(tipo, str);
        return resultado;
    }
}