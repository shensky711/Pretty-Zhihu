package site.hanschen.pretty.db.gen;

import java.util.Map;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.AbstractDaoSession;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import site.hanschen.pretty.db.bean.Picture;
import site.hanschen.pretty.db.bean.Question;

import site.hanschen.pretty.db.gen.PictureDao;
import site.hanschen.pretty.db.gen.QuestionDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see org.greenrobot.greendao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig pictureDaoConfig;
    private final DaoConfig questionDaoConfig;

    private final PictureDao pictureDao;
    private final QuestionDao questionDao;

    public DaoSession(Database db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        pictureDaoConfig = daoConfigMap.get(PictureDao.class).clone();
        pictureDaoConfig.initIdentityScope(type);

        questionDaoConfig = daoConfigMap.get(QuestionDao.class).clone();
        questionDaoConfig.initIdentityScope(type);

        pictureDao = new PictureDao(pictureDaoConfig, this);
        questionDao = new QuestionDao(questionDaoConfig, this);

        registerDao(Picture.class, pictureDao);
        registerDao(Question.class, questionDao);
    }
    
    public void clear() {
        pictureDaoConfig.clearIdentityScope();
        questionDaoConfig.clearIdentityScope();
    }

    public PictureDao getPictureDao() {
        return pictureDao;
    }

    public QuestionDao getQuestionDao() {
        return questionDao;
    }

}
