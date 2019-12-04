package ImageHoster.service;

import ImageHoster.HardCodedImage;
import ImageHoster.model.Image;
import ImageHoster.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ImageService {
    @Autowired
    private ImageRepository imageRepository;

    private HardCodedImage hardCodedImage = new HardCodedImage();

    private List<Image> images = new ArrayList<>();

    public ImageService() {

        Date date = new Date();

        images.add(new Image(1, "Dr. Strange", hardCodedImage.getDrStrange(), date));
        images.add(new Image(2, "SpiderMan", hardCodedImage.getSpiderMan(), date));

            }

    //The method returns the list of two harc-coded images
    public List<Image> getAllImages() {
        return new ImageService().images;
    }

   //The method calls the createImage() method in the Repository and passes the image to be persisted
   // in the database
    public void uploadImage(Image image) {
        imageRepository.uploadImage(image);
    }

}
