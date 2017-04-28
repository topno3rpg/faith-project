package proxy.jdk;

/**
 * 目标对象
 */
public class UserServiceImpl implements UserService {

    /* (non-Javadoc)
     * @see dynamic.UserService#add()
     */
    public void add() {
        System.out.println("--------------------add---------------");
    }
}
