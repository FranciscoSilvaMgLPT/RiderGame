public enum Colors {

    RESET {
        public String toString() {
            return "\033[0m";
        }
    },
    BLACK {
        public String toString() {
            return "\033[0;30m";
        }
    },
    RED {
        public String toString() {
            return "\033[0;31m";
        }
    },
    GREEN {
        public String toString() {
            return "\033[0;32m";
        }
    },
    YELLOW {
        public String toString() {
            return "\033[0;33m";
        }
    },
    BLUE {
        public String toString() {
            return "\033[0;34m";
        }
    },
    PURPLE {
        public String toString() {
            return "\033[0;35m";
        }
    },
    CYAN {
        public String toString() {
            return "\033[0;36m";
        }
    },
    WHITE {
        public String toString() {
            return "\033[0;37m";
        }
    };


}
