import ciphers.Encrypt;

public enum Operation {
    ENCRYPT {
        @Override
        public void apply(Encrypt algo) {
            algo.encrypt();
        }
    },
    DECRYPT {
        @Override
        public void apply(Encrypt algo) {
            algo.decrypt();
        }
    },
    ERROR2 {
        @Override
        public void apply(Encrypt algo) {
            algo.decrypt();
        }
    };

    public abstract void apply(Encrypt algo);
}

