public class Flyweight {

    public static class WorldObj {

        private int x, y, z, angleX, angleY, size;
        public boolean isDestroyed = false;

        private ObjectType type;

        public WorldObj(int x, int y, int z, int angleX, int angleY, int size, ObjectType type) {
            this.z    = z;
            this.x    = x;
            this.y    = y;
            this.size = size;
            this.type = type;
        }

        public String askName() {
            return type.name;
        }

        public void check() {

            System.out.printf(
                    "WorldObj with params: x = %d, y = %d, z = %d, angleX = %d, angleY = %d, size = %d, type = '%s' was created.%n",
                    this.x, this.y, this.z, this.angleX, angleY, this.size, this.type.name
            );
        }

        public void destroy() {
        }
    }

    public static class ObjectType {
        private String name;
        private String color;

        public ObjectType(String name, String color) {
            this.name = name;
            this.color = color;
            check();
        }

        public void check() {
            System.out.printf("ObjectType with name '%s' which has params: color = '%s' was created.%n", this.name, this.color);
        }
    }


}
