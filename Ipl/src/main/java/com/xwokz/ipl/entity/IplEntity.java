package com.xwokz.ipl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
@Table(name="ipl_table")
@NamedQuery(name="findTeamName",query="select entity.nameOfTheTeam from IplEntity entity where entity.caption=:nameBy")

@NamedQuery(name="findTeamMembers",query="select entity.noOfMembers from IplEntity entity where entity.noOfMembers=:membersBy")

@NamedQuery(name="findTeamNameAndcolour",query="select entity.nameOfTheTeam,entity.colour from IplEntity entity where entity.nameOfTheTeam=:entityBy")

public class IplEntity {
	
@Id
@Column(name="id")
private int id;
@Column(name="team_name")
private String nameOfTheTeam;
@Column(name="members")
private int noOfMembers;
@Column(name="caption")
private String caption;
@Column(name="amasdor")
private String ambasdor;
@Column(name="colour")
private String colour;

}
