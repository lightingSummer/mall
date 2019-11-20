package club.lightingsummer.mall.manage.util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

/**
 * @author light
 * @date 2019/11/20 0020 21:25
 */
public class PmsUploadUtil {
    private static final Logger logger = LoggerFactory.getLogger(PmsUploadUtil.class);
    private static final String urlHead = "http://121.36.16.58";

    /**
     * description: fastdfs上传图片
     *
     * @param multipartFile 文件
     * @return java.lang.String 返回url
     */
    public static String uploadImage(MultipartFile multipartFile) {
        StringBuilder imageUrl = new StringBuilder();
        imageUrl.append(urlHead);
        try {
            // 获得配置文件的路径
            String tracker = PmsUploadUtil.class.getResource("/tracker.properties").getPath();
            ClientGlobal.init(tracker);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageClient storageClient = new StorageClient(trackerServer, null);

            // 获得文件二进制流和后缀名
            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.indexOf('.') + 1);
            String[] uploadInfos = storageClient.uploadFile(bytes, extName, null);
            for (String uploadInfo : uploadInfos) {
                imageUrl.append('/');
                imageUrl.append(uploadInfo);
            }
            return imageUrl.toString();
        } catch (Exception e) {
            logger.error("fastdfs调用失败" + e.getMessage() + Arrays.toString(e.getStackTrace()));
            return null;
        }
    }
}
