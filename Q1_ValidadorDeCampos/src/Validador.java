public class Validador {
    private ValidadorStrategy estrategia;

    public void setEstrategia(ValidadorStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public boolean valida(String valor) {
        if (estrategia == null) {
            throw new IllegalStateException("Estratégia não definida.");
        }
        return estrategia.valida(valor);
    }

    public interface ValidadorStrategy {
        boolean valida(String valor);
    }
    
    public static class ValidadorEmail implements ValidadorStrategy {
        @Override
        public boolean valida(String valor) {
            int posA = valor.indexOf('@');
            int posPt = valor.indexOf('.');
            return posA > 0 && posPt > 0;
        }
    }
    
    public static class ValidadorInteiro implements ValidadorStrategy {
        @Override
        public boolean valida(String valor) {
            for (int i = 0; i < valor.length(); i++) {
                if (!Character.isDigit(valor.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }
    
    public static class ValidadorMatricula implements ValidadorStrategy {
        @Override
        public boolean valida(String valor) {
            if (!new ValidadorInteiro().valida(valor)) {
                return false;
            } else {
                int sum = 0;
                for (int i = 0; i < valor.length() - 1; i++) {
                    sum += Character.getNumericValue(valor.charAt(i));
                }
                int verificador = sum % 10;
                return verificador == Character.getNumericValue(valor.charAt(valor.length() - 1));
            }
        }
    }
}
