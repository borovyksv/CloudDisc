package sources;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by user-pc on 10.08.2016.
 */
public interface DataService {
    void addContact(MultipartFile f);
}
