package org.scoula.travel.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.opencsv.bean.CsvToBeanBuilder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.scoula.config.ProjectConfig;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { ProjectConfig.class })
class TravelDaoImplTest {

    @Autowired
    TravelDao dao;
    @Test
    @Disabled
    void create() throws IOException, SQLException {
        List<TravelVO> members = new CsvToBeanBuilder<TravelVO>(new FileReader("travel.csv", StandardCharsets.UTF_8))
                .withType(TravelVO.class)
                .build()
                .parse();
        for(TravelVO travel : members) {
            System.out.println(travel);
//            dao.create(travel);
        }
    }

    @Test
    @Disabled
    void createTravelImages() throws IOException, SQLException {
        String dir = "C:\\Users\\student\\Downloads\\travel\\travel\\travel-image";
        List<TravelImageVO> files = Files.list(Paths.get(dir))
                .map(Path::toFile)
                .map(TravelImageVO::of)
                .toList();
        for(TravelImageVO file: files) {
            System.out.println(file);
//            dao.createImage(file);
        }
    }
}