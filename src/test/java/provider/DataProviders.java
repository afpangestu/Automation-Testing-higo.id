package provider;

import org.testng.annotations.DataProvider;
import util.ExcelUtil;

import java.io.IOException;

public class DataProviders {
    String dataDir = "//src//main//java//data//datatesting.xlsx";

    @DataProvider(name="all_data")
    public String[][] getAllData() throws IOException {
        String path=System.getProperty("user.dir")+dataDir;
        ExcelUtil xl = new ExcelUtil(path);

        int rownum = xl.getRowCount("Sheet1");
        int colcount = xl.getCellCount("Sheet1",1);

        String apidata[][] = new String[rownum][colcount];

        for(int i=1;i<=rownum;i++) {
            for(int j=0;j<colcount;j++) {
                apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name="contact_higo")
    public String[][] getContact() throws IOException {
        String path=System.getProperty("user.dir")+dataDir;
        ExcelUtil xl = new ExcelUtil(path);

        int rownum = xl.getRowCount("ContactHIGO");
        int colcount = xl.getCellCount("ContactHIGO",1);

        String apidata[][] = new String[rownum][colcount];

        for(int i=1;i<=rownum;i++) {
            for(int j=0;j<colcount;j++) {
                apidata[i-1][j]=xl.getCellData("ContactHIGO", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name="XSS_test")
    public String[][] executeXSS() throws IOException {
        String path=System.getProperty("user.dir")+dataDir;
        ExcelUtil xl = new ExcelUtil(path);

        int rownum = xl.getRowCount("Payload");
        int colcount = xl.getCellCount("Payload",1);

        String apidata[][] = new String[rownum][colcount];

        for(int i=1;i<=rownum;i++) {
            for(int j=0;j<colcount;j++) {
                apidata[i-1][j]=xl.getCellData("Payload", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name="normal_comment")
    public String[][] normalComment() throws IOException {
        String path=System.getProperty("user.dir")+dataDir;
        ExcelUtil xl = new ExcelUtil(path);

        int rownum = xl.getRowCount("NormalComment");
        int colcount = xl.getCellCount("NormalComment",1);

        String apidata[][] = new String[rownum][colcount];

        for(int i=1;i<=rownum;i++) {
            for(int j=0;j<colcount;j++) {
                apidata[i-1][j]=xl.getCellData("NormalComment", i, j);
            }
        }
        return apidata;
    }
}
