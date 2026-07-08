package mcp.amolD;



public class MyService {

    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchData(int id) {
        return api.getData(id);
    }

    public void printData(String data) {
       api.printData(data);
    }



}