package com.wcs.githubacces.utils;

import com.wcs.githubacces.entities.Githuber;
import com.wcs.githubacces.repositories.GithuberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Outputter implements CommandLineRunner {

    private Logger LOG = LoggerFactory.getLogger("Wilder");

    @Autowired
    private GithuberRepository gitDao;

    @Override
    public void run(String... args) throws Exception {

        // Checke combien d'objets se trouvent dans la BDD
        LOG.info("******************");
        LOG.info("Objects in DB : " + gitDao.count());
        // Liste les utilisateurs enregistrés dans la BDD
        LOG.info("CREATE  ******************");
        Githuber newGit= new Githuber(777L,"newGitName","newGitMail","newGitLogin","newAvatar");
        try {   // Si gitId 777 deja present, la BD refuse de renter le meme gitId
            gitDao.save(newGit);
        }
        catch (Exception ex) {
            ; //throw ex;               C'est pas grave
        }
        LOG.info(newGit.toString()+" Created");

        LOG.info("READ  ******************");
        LOG.info("List of githuber is ");
        for(Githuber git : gitDao.findAll()) {
            LOG.info(git.toString());
        };

        LOG.info("UPDATE  ******************");
        // Search for the githuber with "newGitName" name
        Githuber gitSearch= new Githuber(null,"newGitName",null,null,null);
        Example<Githuber> example=  Example.of(gitSearch);
        LOG.info("Search for git with name equal "+gitSearch.getName());
        ArrayList<Githuber> listGit= (ArrayList<Githuber>) gitDao.findAll(example);
        LOG.info(String.format("Get %d elements",listGit.size()));
        Githuber myGit=listGit.get(0);
        LOG.info("Git found : "+ myGit.toString());
        Long idAdded =myGit.getId();      // Get id in database
        myGit.setgitId(888L);
        gitDao.save(myGit);     // Update
        Githuber gitUpdated= gitDao.findById(idAdded).get();
        LOG.info("New git value: "+gitUpdated.toString());
        LOG.info("DELETE  ******************");
        gitDao.delete(gitUpdated);

        LOG.info("List of githuber is ");
        for(Githuber git : gitDao.findAll()) {
            LOG.info(git.toString());
        };
    }
}
