package com.example.examenspringboot.services;

import com.example.examenspringboot.entities.*;
import com.example.examenspringboot.repository.Museerepository;
import com.example.examenspringboot.repository.Artrepository;
import com.example.examenspringboot.repository.Personnelrepository;
import com.example.examenspringboot.repository.Zonerepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
@Slf4j

public class service implements Iservice{

    @Autowired
    Museerepository mr;
    @Autowired
    Artrepository ar;
    @Autowired
    Zonerepository zr;
    @Autowired
    Personnelrepository pr;


    @Override
    public Musee ajouterMusee(Musee musee) {
        return mr.save(musee);
    }

    @Override
    public Zone ajouterZoneEtAffecterAMusee(Zone zone, Long idMusee) {
        Musee m=mr.findById(idMusee).orElse(null);
        zone.setMusee(m);
        return zr.save(zone);
    }

    @Override
    public OeuvreArt ajouterOeuvreArtEtAffecterAZone(OeuvreArt oeuvreArt, Long idZone) {
        Zone z=zr.findById(idZone).orElse(null);
        oeuvreArt.setZonee(z);
        return ar.save(oeuvreArt);
    }

    @Override
    public void affecterPersonnelsAZone(Long idZone, Long idGardien, Long idDirecteur) {
        Zone z= zr.findById(idZone).orElse(null);
        Personnel gardien=pr.findPersonnelByIdPersonnelAndAndTypePersonnel(idGardien, TypePersonnel.GARDIEN);
        Personnel directeur=pr.findPersonnelByIdPersonnelAndAndTypePersonnel(idDirecteur,TypePersonnel.DIRECTEUR);
       // z.getPersonnelList().add(gardien);
        //z.getPersonnelList().add(directeur);
        //zr.save(z);
       gardien.setZone(z);
        directeur.setZone(z);

        pr.save(gardien);
        pr.save(directeur);

    }

    @Override
    public List<String> titreTableauParMuseeEtDirection(Long idMusee, Direction direction) {
        List<String> a=new ArrayList<>();
        String x=null;

        Musee m=mr.findById(idMusee).orElse(null);
        List<Zone> zl=m.getZones();
        for(Zone z:zl)
        {
            if(z.getDirection().equals(direction))
            {
                for(OeuvreArt o:z.getOeuvreArts())
                 x=o.getTitreTableau();
                a.add(x);
                }
            }
        return a;
        }
    @Transactional
    @Scheduled(cron = "*/30 * * * * *")
    void desaffecterDirecteursZoneInactif()
    {
       List<Zone> aa=zr.findAll();
       for(Zone x:aa)
       {
           if(!x.isActif())
           {
             x.setPerso(null);
             zr.save(x);
           }
       }


    }
}

