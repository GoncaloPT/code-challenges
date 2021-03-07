package pt.goncalo.interfaces;

public abstract class VisibilityCheckImpl implements VisibilityCheck {

    /**
    @Override

     * Since interface has public visibility this has a compile error

    protected void doIt() {
    }
     */
    @Override
    public void doIt() {

    }

    protected abstract void doItInProtection();


    public static class Implementation extends VisibilityCheckImpl{

       /* @Override
        protected void doItInProtection() {

        }*/

        /**
         * Although this visibility level is different from the parent ( parent is protected ) this is
         * ok since it has a wider permission level. The override permission must be equal or wider.
         * Inside a class private < default(package-private) < protected < public
         */
        @Override
        public void doItInProtection() {

        }
    }
}
