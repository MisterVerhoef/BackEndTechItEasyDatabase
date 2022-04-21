package nl.novi.backend.techiteasy.Service;

import nl.novi.backend.techiteasy.Exceptions.RecordNotFoundException;
import nl.novi.backend.techiteasy.Models.Television;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionService {

        public List<Television> getTelevision() {
            return ListOfTelevision.getTelevision();
        }


        public Television getTelevision(int id) {
            Television televisionFound = ListOfTelevision.getTelevision(id);
            if (televisionFound == null)
                throw new RecordNotFoundException("Cannot find television");
            return televisionFound;
        }

        public int addTelevision(Television television) {
            return ListOfTelevision.addTelevision(television);
        }


        public void removeTelevision(int id) {
            Television televisionFound = ListOfTelevision.getTelevision(id);
            if (televisionFound == null)
                throw new RecordNotFoundException("Cannot find television");
            ListOfTelevision.getTelevision(id);
        }


        public void updateTelevision(int id, Television television) {
            Television televisionFound = ListOfTelevision.getTelevision(id);
            if (televisionFound == null)
                throw new RecordNotFoundException("Cannot find television");
            ListOfTelevision.updateTelevision(id, television);
        }
    }

