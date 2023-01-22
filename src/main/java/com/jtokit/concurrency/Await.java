package com.jtokit.concurrency;

public class Await {

    private Await() {

    }

    public static <A> AwaitA<A> awaitA(Class<A> typeA) {
        return new AwaitA<>();
    }

    public static class AwaitA<A> {
        private A responseA;
        private boolean responseASet = false;

        private AwaitA() {

        }

        public A getResponseA() {
            return responseA;
        }

        public void setResponseA(A responseA) {
            this.responseA = responseA;
            responseASet = true;
        }

        public synchronized void await() {
            while (true) {
                if (responseASet) {
                    return;
                }

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
