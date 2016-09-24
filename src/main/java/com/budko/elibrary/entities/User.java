package com.budko.elibrary.entities;

import com.budko.elibrary.entities.enums.UserRoles;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Locale;

/**
 * @author DBudko.
 */
@Entity
@Table(name = "viewer_card")
public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_Id")
    private Integer id;
    @NotEmpty(message = "Email не може бути пустим")
    @Email(message = "Введіть коректний email")
    private String username;
    @NotEmpty(message = "Пароль не може бути пустим")
    private String password;
    @NotEmpty(message = "Будь ласка, введіть ім'я")
    @Column(name = "first_name")
    private String firstName;
    @NotEmpty(message = "Будь ласка, введіть прізвище")
    @Column(name = "last_name")
    private String lastName;
    @NotEmpty(message = "Будь ласка, введіть по-батькові")
    @Column(name = "middle_name")
    private String middleName;
    @NotEmpty(message = "Заповніть будь-ласка адресу")
    private String address;
    @NotEmpty(message = "Введіть телефон")
    private String phoneNumber;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Calendar birthday;
    @NotEmpty(message = "Введіть вашу посаду")
    private String position;
    @NotEmpty(message = "Введіть ваш підрозділ")
    private String department;
    @NotEmpty(message = "Введіть ваші паспортні дані")
    private String passport;
    private boolean enabled;
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "roleid")
    private UserRoles role;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirhday(String birhday) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
        System.out.println(birhday);
        try {
            cal.setTime(sdf.parse(birhday));// all done
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(cal);
        this.birthday = cal;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    //     User details methods

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }


    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", birthday=" + birthday +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", passport='" + passport + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                ", faculty=" + faculty +
                '}';
    }
}
