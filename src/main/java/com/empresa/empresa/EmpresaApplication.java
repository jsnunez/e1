package com.empresa.empresa;

import java.util.List;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.empresa.empresa.domain.PermissionEntity;
import com.empresa.empresa.domain.RoleEntity;
import com.empresa.empresa.domain.RoleEnum;
import com.empresa.empresa.domain.UserEntity;
import com.empresa.empresa.infrastructure.repository.UserRepository;

@SpringBootApplication
public class EmpresaApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpresaApplication.class, args);
	}
	@Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
            /* Create PERMISSIONS */
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();

            /* Create ROLES */
            RoleEntity roleAdmin = RoleEntity.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();

            RoleEntity roleUser = RoleEntity.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();

            RoleEntity roleInvited = RoleEntity.builder()
                    .roleEnum(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();

            RoleEntity roleDeveloper = RoleEntity.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
                    .build();

            /* CREATE USERS */
            UserEntity userSantiago = UserEntity.builder()
                    .username("santiago")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            UserEntity userDaniel = UserEntity.builder()
                    .username("daniel")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            UserEntity userAndrea = UserEntity.builder()
                    .username("andrea")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();

            UserEntity userAnyi = UserEntity.builder()
                    .username("anyi")
                    .password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

                    // Define roles
RoleEntity roleJefeBodega = RoleEntity.builder()
.roleEnum(RoleEnum.JEFEBODEGA)
.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
.build();

RoleEntity roleCliente = RoleEntity.builder()
.roleEnum(RoleEnum.CLIENTE)
.permissionList(Set.of(readPermission)) // Adjust permissions as needed
.build();

RoleEntity roleGerente = RoleEntity.builder()
.roleEnum(RoleEnum.GERENTE)
.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
.build();

RoleEntity roleJefeInventario = RoleEntity.builder()
.roleEnum(RoleEnum.JEFEINVENTARIO)
.permissionList(Set.of(createPermission, readPermission, updatePermission))
.build();

RoleEntity roleJefeRecursosHumanos = RoleEntity.builder()
.roleEnum(RoleEnum.JEFERECUROSHUMANOS)
.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
.build();

RoleEntity roleJefeMarketing = RoleEntity.builder()
.roleEnum(RoleEnum.JEFEMARKETING)
.permissionList(Set.of(createPermission, readPermission))
.build();

RoleEntity roleJefeCompra = RoleEntity.builder()
.roleEnum(RoleEnum.JEFECOMPRA)
.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
.build();

RoleEntity roleProfesionalServicio = RoleEntity.builder()
.roleEnum(RoleEnum.PROFESIONALSERVICIO)
.permissionList(Set.of(readPermission, updatePermission))
.build();

RoleEntity roleJefeSistemas = RoleEntity.builder()
.roleEnum(RoleEnum.JEFESISTEMAS)
.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
.build();

// Create users for each role
UserEntity userJefeBodega = UserEntity.builder()
.username("jefebodega")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6") // Use hashed password
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleJefeBodega))
.build();

UserEntity userCliente = UserEntity.builder()
.username("cliente")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleCliente))
.build();

UserEntity userGerente = UserEntity.builder()
.username("gerente")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleGerente))
.build();

UserEntity userJefeInventario = UserEntity.builder()
.username("jefeinventario")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleJefeInventario))
.build();

UserEntity userJefeRecursosHumanos = UserEntity.builder()
.username("jeferecursohumanos")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleJefeRecursosHumanos))
.build();

UserEntity userJefeMarketing = UserEntity.builder()
.username("jefemarketing")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleJefeMarketing))
.build();

UserEntity userJefeCompra = UserEntity.builder()
.username("jefec compra")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleJefeCompra))
.build();

UserEntity userProfesionalServicio = UserEntity.builder()
.username("profesionalservicio")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleProfesionalServicio))
.build();

UserEntity userJefeSistemas = UserEntity.builder()
.username("jefesistemas")
.password("$2a$10$cMY29RPYoIHMJSuwRfoD3eQxU1J5Rww4VnNOUOAEPqCBshkNfrEf6")
.isEnabled(true)
.accountNoExpired(true)
.accountNoLocked(true)
.credentialNoExpired(true)
.roles(Set.of(roleJefeSistemas))
.build();

            userRepository.saveAll(List.of(userSantiago, userDaniel, userAndrea, userAnyi,userJefeBodega,userCliente,
            userGerente, userJefeInventario, userJefeRecursosHumanos, userJefeMarketing, userJefeCompra, userProfesionalServicio, userJefeSistemas));


        };

	}

}
