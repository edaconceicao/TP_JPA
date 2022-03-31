package jaxrs;

import io.undertow.Undertow;
import jaxrs.dao.generic.FicheDao;
import jaxrs.dao.generic.KanbanDao;
import jaxrs.dao.generic.SectionDao;
import jaxrs.dao.generic.UtilisateurDao;
import jaxrs.domain.Fiche;
import jaxrs.domain.KanbanBoard;
import jaxrs.domain.Section;
import jaxrs.domain.Utilisateur;

import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * RESTfull microservice, based on JAX-RS and JBoss Undertow
 *
 */
public class RestServer {

    private static final Logger logger = Logger.getLogger(RestServer.class.getName());

    public static void main( String[] args ) {

        UndertowJaxrsServer ut = new UndertowJaxrsServer();

        TestApplication ta = new TestApplication();

        ut.deploy(ta);

        ut.start(
                Undertow.builder()
                        .addHttpListener(8081, "localhost")

        );

        logger.info("JAX-RS based micro-service running!");
        
        FicheDao ficheDao = new FicheDao();
        KanbanDao kanbanDao = new KanbanDao();
        KanbanBoard kanban = new KanbanBoard();
        kanban.setNom("Kanban");
        kanbanDao.save(kanban);

        KanbanBoard kanban2 = new KanbanBoard();
        kanban2.setNom("Kanban2");
        kanbanDao.save(kanban2);

        Section section = new Section();
        section.setNom("section1");
        section.setKanbanBoard(kanban);
        SectionDao sectionDao = new SectionDao();
        sectionDao.save(section);

        Section section1 = new Section();
        section1.setNom("section2");
        section1.setKanbanBoard(kanban);
        sectionDao.save(section1);

        Section section2 = new Section();
        section2.setNom("section");
        section2.setKanbanBoard(kanban2);
        sectionDao.save(section2);

        Utilisateur user = new Utilisateur();
        user.setMail("Marie@gmail.com");
        user.setNom("Marie");

        List<KanbanBoard> kanbans = new ArrayList<>();
        kanbans.add(kanban);
        kanbans.add(kanban2);
        user.setKanbanBoards(kanbans);
        UtilisateurDao userDao = new UtilisateurDao();
        userDao.save(user);

        Fiche f = new Fiche();
        f.setLibelle("Fiche1");
        f.setLieu("lieu");
        f.setNote("note");
        f.setPosition(1);
        f.setSection(section);
        f.setUtilisateur(user);
        ficheDao.save(f);

        Fiche f2 = new Fiche();
        f2.setLibelle("Fiche2");
        f2.setPosition(1);
        f2.setSection(section1);
        f2.setUtilisateur(user);
        ficheDao.save(f2);

        Fiche f3 = new Fiche();
        f3.setLibelle("Fiche3");
        f3.setPosition(1);
        f3.setSection(section2);
        f3.setUtilisateur(user);
        ficheDao.save(f3);

    }
}
