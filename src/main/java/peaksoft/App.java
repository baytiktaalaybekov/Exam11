package peaksoft;

import peaksoft.Company.Company;
import peaksoft.Util.ConnectionDataBase;
import peaksoft.model.Developers;
import peaksoft.service.DevelopersSer;
import peaksoft.service.DevelopersSerImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
//        ConnectionDataBase.getConnection();

        DevelopersSer developersSer = new DevelopersSerImpl();
        developersSer.create();
        developersSer.save(new Developers(1L,"B", (byte) 20,"fgdg"));
        developersSer.findById(1L);
        developersSer.getAll();
        developersSer.delete(1L);
        developersSer.update(1L,new Developers(2L,"fdg",(byte) 21,"df"));

    }
}
