package passwordmanagers.ui.dialog;

public enum Choice {

    ADD {
        @Override
        public String toString() {
            return "Add";
        }
    }
    ,
    EDIT {
        @Override
        public String toString() {
            return "Edit";
        }
    }
}
