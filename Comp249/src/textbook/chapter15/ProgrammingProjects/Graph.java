package chapter15.ProgrammingProjects;

public class Graph {
    private class Nodes{
        private char value;
        private Nodes north;
        private Nodes south;
        private Nodes west;
        private Nodes east;

        public Nodes(){}
        public Nodes(char value, Nodes north, Nodes south, Nodes west, Nodes east) {
            this.value = value;
            this.north = north;
            this.south = south;
            this.west = west;
            this.east = east;
        }

        public boolean addToNorth(char value){
            if(north!=null)
                return false;
            north = new Nodes(value, null, this, null, null);
            return true;
        }

        public boolean addToSouth(char value){
            if(south!=null)
                return false;
            south = new Nodes(value, this, null, null, null);
            return true;
        }

        public boolean addToWest(char value){
            if(west!=null)
                return false;
            west = new Nodes(value, null, null, null, this);
            return true;
        }

        public boolean addToEast(char value){
            if(east!=null)
                return false;
            east = new Nodes(value, null, null, this, null);
            return true;
        }
    }




    private Nodes start;
    private Nodes finish;

    public Graph(){
        start = new Nodes('A', null, null, null, null);
        start.addToEast('B');
    }

}
