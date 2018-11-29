package model;

import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3ObjectSummary;

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
