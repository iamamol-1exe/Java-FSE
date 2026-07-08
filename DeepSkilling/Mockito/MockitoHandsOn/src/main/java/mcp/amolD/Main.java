package mcp.amolD;



class Main{
    public static void main(String[] args) {
        ExternalApi externalApi = new ExternalApi();
        MyService service = new MyService(externalApi);

        System.out.println(service.fetchData(12));

    }
}