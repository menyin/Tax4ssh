package console;

import com.cny.nsfw.role.entity.Role;
import com.cny.nsfw.role.entity.RolePrivilege;
import com.cny.nsfw.role.entity.RolePrivilegeKey;
import com.cny.nsfw.role.service.RoleService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cny.core.constant.Constant;

import java.util.HashSet;
import java.util.Set;

public class TestHibernate {
    @Test
    public void Test(){


        System.out.println("测试角色相关的hibernate功能");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-cfg.xml");
        RoleService roleService = (RoleService) ac.getBean("roleService");
        System.out.println(roleService);

        /*//增加
        Role role = new Role();
        RolePrivilege rolePrivilege = new RolePrivilege(new RolePrivilegeKey(role,Constant.PRIVILEGE_NSFW));
        Set<RolePrivilege> set=new HashSet<RolePrivilege>();
        set.add(rolePrivilege);
        role.setName("王五");
        role.setState("0");
        role.setRolePrivilege(set);
        roleService.save(role);*/

        /*//删除 测试失败
        Role role1 = new Role();
        role1.setRoleId("402881ac615015900161501591e20000");
        roleService.delete(role1.getRoleId());//删除王五*/

        /*//修改 修改时其实还要携带关联的权限信息，所以要先查询
        Role wanwu = roleService.findObjectById("402881ac615015900161501591e20000");
        wanwu.setName("王五哥哥");
        System.out.println(wanwu);
        roleService.update(wanwu);*/

        /*//查询
        Role role = roleService.findObjectById("402881ac615015900161501591e20000");
        System.out.println(role.getRoleId());
        System.out.println(role.getName());*/
    }
}
