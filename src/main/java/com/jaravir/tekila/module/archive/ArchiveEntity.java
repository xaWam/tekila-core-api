package com.jaravir.tekila.module.archive;

import com.jaravir.tekila.base.auth.persistence.User;
import com.jaravir.tekila.base.entity.BaseEntity;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Objects;

/**
 * Created by sajabrayilov on 8/6/2015.
 */
public class ArchiveEntity<S extends BaseEntity, T extends BaseEntity> {
    private long sourceID;
    private DateTime archivedDate;
    private long objectVersion;
    private User archivingUser;

    public ArchiveEntity() {
    }

    public ArchiveEntity(S source, T target) {
        target.setId(DateTime.now().getMillis());
        sourceID = source.getId();
        Object fieldValue = null;
        Field thisField = null;
        Class sourceClass = source.getClass();
        Class targetClass = target.getClass().getSuperclass();

        do {
            for (Field field : sourceClass.getDeclaredFields()) {
                try {
                    field.setAccessible(true);


                    if ((field.getModifiers() & Modifier.FINAL) == Modifier.FINAL || field.getName().equals("id")) {
                        field.setAccessible(false);
                        continue;
                    }

                    fieldValue = field.get(source);

                    if (fieldValue != null) {
                        //System.out.println(String.format("%s: %s", field.getName(), fieldValue));
                        thisField = targetClass.getDeclaredField(field.getName());
                        thisField.setAccessible(true);
                        thisField.set(target, fieldValue);
                        thisField.setAccessible(false);
                        //getClass().getDeclaredMethod("set" + new String(buffer), fieldValue.getClass()).invoke(this, fieldValue);
                    }

                    field.setAccessible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                    System.out.println("Cannot parse field: " + field.getName());
                }
            }

            sourceClass = sourceClass.getSuperclass();
            targetClass = targetClass.getSuperclass();
        } while (sourceClass != null && !sourceClass.equals(Objects.class));

        archivedDate = DateTime.now();
        objectVersion = target.getId();
        target.setLastUpdateDate();
    }

    public ArchiveEntity(S source, T target, User archivingUser) {
        this(source, target);
        this.archivingUser = archivingUser;
    }
}
