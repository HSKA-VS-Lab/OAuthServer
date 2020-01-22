package de.hska.iwi.vslab.OAuthServer.repository;

import de.hska.iwi.vslab.OAuthServer.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

}