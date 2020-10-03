package com.chea.blablacar.technicaltest.model.mower;

public enum Direction {

    N {
        @Override
        public Direction turn(Move move) {
            switch (move) {
                case L:
                    return W;
                case R:
                    return E;
                default:
                    return N;
            }
        }
    },

    S {
        @Override
        public Direction turn(Move move) {
            switch (move) {
                case L:
                    return E;
                case R:
                    return W;
                default:
                    return S;
            }
        }
    },

    E {
        @Override
        public Direction turn(Move move) {
            switch (move) {
                case L:
                    return N;
                case R:
                    return S;
                default:
                    return E;
            }
        }
    },

    W {
        @Override
        public Direction turn(Move move) {
            switch (move) {
                case L:
                    return S;
                case R:
                    return N;
                default:
                    return W;
            }
        }
    };


    public abstract Direction turn(Move move);

}
