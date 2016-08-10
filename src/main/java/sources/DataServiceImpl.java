package sources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by user-pc on 10.08.2016.
 */
public class DataServiceImpl implements DataService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addContact(MultipartFile f) {

    }
}
