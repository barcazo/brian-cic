package za.co.brian.restservice;

import za.co.brian.restservice.model.Cic;
import za.co.brian.restservice.model.Entity;
import za.co.brian.restservice.repository.EntityRepository;
import za.co.brian.restservice.repository.CicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class H2DatabaseInitializer implements CommandLineRunner {

    private EntityRepository entityRepository;
    private CicRepository cicRepository;

    @Autowired
    public H2DatabaseInitializer(EntityRepository entityRepository, CicRepository cicRepository) {
        this.entityRepository = entityRepository;
        this.cicRepository = cicRepository;
    }

    @Override
    public void run(String... strings) {

        Entity entity1 = new Entity("c.brian", "brian@c.com");
        Entity entity2 = new Entity("barca", "barca@brian.co.za");
        Entity entity3 = new Entity("brianch", "brian@eoh.co.za");

        Cic cic1 = new Cic
                ("cicType","EOH-CIC","What is the purpose of this web service","SON", Date.valueOf("2018-06-10"), entity1);
         Cic cic2 = new Cic
                ("cicType2","EOH DIGITAL PLATOON ","Java Rest API with H2","SON", Date.valueOf("2018-06-10"), entity1);
         Cic cic3 = new Cic
                ("cicType3","EOH - Digital","The eoh cic assessment","SON", Date.valueOf("2018-06-10"), entity1);


        this.entityRepository.save(entity1);
        this.cicRepository.save(cic1);
        this.cicRepository.save(cic2);
        this.cicRepository.save(cic3);

        this.entityRepository.save(entity2);
        this.cicRepository.save(cic2);
        this.cicRepository.save(cic3);

        this.entityRepository.save(entity3);

    }
}
