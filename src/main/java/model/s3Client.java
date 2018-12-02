package model;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class s3Client {

            public static AmazonS3 gets3Client(){
//                final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
//                        .withRegion("us-east-2")
//                        .withCredentials(new InstanceProfileCredentialsProvider(false))
//                        .build();
                Properties p = new Properties( );
                try {
                    p.load( new FileInputStream( new File("/tmp/credentials")));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String accessKey = p.getProperty("aws_access_key_id");
                String secretKey = p.getProperty("aws_secret_access_key");

                BasicAWSCredentials creds = new BasicAWSCredentials(accessKey, secretKey);
                AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                        .withRegion("us-east-2")
                        .withCredentials(new AWSStaticCredentialsProvider(creds)).build();

                return s3Client;
            }

            public static void getBucketList(){
            //final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
                AmazonS3 client = gets3Client();

                // List of buckets
                List<Bucket> buckets = client.listBuckets();
                System.out.println("Your Amazon S3 buckets are:");
                for (Bucket b : buckets)
                {
                System.out.println("* " + b.getName());
                }

        }

        public static List<String> getObjectsFromBucket(String bucket){
                AmazonS3 client = gets3Client();
                ArrayList<String> bucketList= new ArrayList<>();
            String s3BaseUrl = "https://s3.us-east-2.amazonaws.com/photo-journal/";
                //List of Objects in a bucket
            String prefix = "static/img_t/" + bucket;
                List<S3ObjectSummary> s3objects = client.listObjects("photo-journal",prefix).getObjectSummaries();

                System.out.println("Your Amazon Concerts objects are:");
                for (S3ObjectSummary a : s3objects)
                {
                    System.out.println("* " + a.getKey());
                    bucketList.add(s3BaseUrl + a.getKey());
                }

            return bucketList;
        }

        public static void putObjectsInBucket(String file, String filePath){

                AmazonS3 s3Client =gets3Client();
                String clientRegion = "us-east-2";
                String bucketName = "photo-journal/static/img_t/myuploads";
                String stringObjKeyName = file;
                String fileObjKeyName = file;
                String fileName = filePath;

            try {
                // Upload a text string as a new object.
                s3Client.putObject(bucketName, stringObjKeyName, "Uploaded String Object");

                // Upload a file as a new object with ContentType and title specified.
                PutObjectRequest request = new PutObjectRequest(bucketName, fileObjKeyName, new File(fileName));
                ObjectMetadata metadata = new ObjectMetadata();
                metadata.setContentType("multipart/form-data");
//                metadata.addUserMetadata("x-amz-meta-title", "someTitle");
                request.setMetadata(metadata);
                s3Client.putObject(request);
            }
            catch(AmazonServiceException e) {
                // The call was transmitted successfully, but Amazon S3 couldn't process
                // it, so it returned an error response.
                e.printStackTrace();
            }
            catch(SdkClientException e) {
                // Amazon S3 couldn't be contacted for a response, or the client
                // couldn't parse the response from Amazon S3.
                e.printStackTrace();
            }
        }



        public static void test(){
            AmazonS3 client = gets3Client();
            ArrayList<String> bucketList= new ArrayList<>();
            String s3BaseUrl = "https://s3.us-east-2.amazonaws.com/photo-journal/";
            //List of Objects in a bucket
            String prefix = "static/img_t/" + "kids";
            List<S3ObjectSummary> s3objects = client.listObjects("photo-journal",prefix).getObjectSummaries();

            System.out.println("Your Amazon Concerts objects are:");
            for (S3ObjectSummary a : s3objects)
            {
                System.out.println("* " + a.getKey());
                bucketList.add(s3BaseUrl + a.getKey());
            }

        }
}
