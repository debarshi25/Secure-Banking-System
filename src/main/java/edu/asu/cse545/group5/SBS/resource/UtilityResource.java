package edu.asu.cse545.group5.SBS.resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/utility")
public class UtilityResource {
   
    @GetMapping("/getLogFile")
    public ResponseEntity<String> getAllEmployee() throws IOException {
        
        //Read the contents of the file
        String content = readFile("CSE-545-Group-5-SBS/src/main/java/edu/asu/cse545/group5/SBS/log/logfile.log",StandardCharsets.US_ASCII);

        return new ResponseEntity<String>(content, HttpStatus.OK);
    }

    static String readFile(String path, Charset encoding) throws IOException
    {
       byte[] encoded = Files.readAllBytes(Paths.get(path));
       return new String(encoded, encoding);
    }
}
