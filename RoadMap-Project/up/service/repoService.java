package service;

import model.repo;

public class repoService {
    public repo convertToRepo(String dataRepo) {

        int indexOf_Id = dataRepo.indexOf("\"id\"");
        int indexOf_Name = dataRepo.indexOf("\"name\"");
        int indexOf_Url = dataRepo.indexOf("\"url\"");

        String id = dataRepo.substring(indexOf_Id + 5, indexOf_Name - 1);

        String name = dataRepo.substring(indexOf_Name + 8, indexOf_Url - 2);

        // This is index of end url attribute, it's "},", support for get value of "url"
        int indexOf_EndUrl = dataRepo.indexOf("}", indexOf_Name);

        String url = dataRepo.substring(indexOf_Url + 6, indexOf_EndUrl);

        return new repo(id, name, url);

    }
}
