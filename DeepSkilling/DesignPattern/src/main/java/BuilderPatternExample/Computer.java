package BuilderPatternExample;

public class Computer
{
    private String CpuName;
    private int RamSize;
    private int DiskSize;


    private Computer (ComputerBuilder builder){
        this.CpuName = builder.CpuName;
        this.RamSize = builder.RamSize;
        this.DiskSize = builder.DiskSize;
    }

    public String getCpuName() {
        return CpuName;
    }

    public int getRamSize() {
        return RamSize;
    }

    public int getDiskSize() {
        return DiskSize;
    }

    static  class ComputerBuilder{
        private String CpuName;
        private int RamSize;
        private int DiskSize;

        public ComputerBuilder (){

        }

        public ComputerBuilder setCpuName(String cpuName) {
            this.CpuName = cpuName;
            return this;
        }

        public ComputerBuilder setRamSize(int ramSize) {
            RamSize = ramSize;
            return  this;
        }

        public ComputerBuilder setDiskSize(int diskSize) {
            DiskSize = diskSize;
            return this;
        }
        public Computer createComputer(){
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return STR."Computer{CpuName='\{CpuName}', RamSize=\{RamSize}, DiskSize=\{DiskSize}}";
    }
}
