import java.util.Iterator;
import java.util.Scanner;

public class PassCrack implements Runnable{
    @Override
    public void run() {

        Main main = new Main();
        int panjang = Main.length;
        String pass = Main.pw;

        SequentialPatternGenerator generator = new SequentialPatternGenerator(panjang);

        generator.forEachRemaining(test -> {if(pass.equals(test)) {
            System.out.println("Password anda: " + test );
        }});

    }

    private class SequentialPatternGenerator implements Iterator<String> {
        private static final char[] CHOICES = new char[]{'a', 'b', 'c', 'd', 'e', 'f',
                'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        private static final int MAX_INDEX = CHOICES.length - 1;
        private boolean keepProducing = true;
        private final int[] indexes;

        public SequentialPatternGenerator(final int length) {
            indexes = new int[length];
            initIndexes();
        }

        private void initIndexes() {
            for (int i = 0; i < indexes.length; i++) {
                indexes[i] = 0;
            }
        }

        @Override
        public boolean hasNext() {
            if (!keepProducing) {
                return false;
            }

            for (int i = 0; i < indexes.length; i++) {
                if (indexes[i] < MAX_INDEX) {
                    return true;
                }
            }

            return false;
        }

        @Override
        public String next() {
            if (!keepProducing || !hasNext()) {
                return null;
            }

            String next = produceString();
            adjustIndexes();

            return next;
        }

        public void stop() {
            keepProducing = false;
        }

        private void adjustIndexes() {
            int i;
            for(i = 0 ; i < indexes.length ; i++) {
                if(indexes[i] < MAX_INDEX) {
                    indexes[i] = indexes[i] + 1;
                    break;
                }
            }

            for(int j=0; j < i; j++) {
                indexes[j] = 0;
            }
        }

        private String produceString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < indexes.length; i++) {
                sb.append(CHOICES[indexes[i]]);
            }

            return sb.toString();
        }
    }
}

