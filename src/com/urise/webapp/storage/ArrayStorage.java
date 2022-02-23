package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
    }

   public void save(Resume r) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                System.out.println("Резюме есть в базе" + r.getUuid());
            } else if (size == storage.length) {
                System.out.println("Переполнена база" + size);
            } else {
                storage[size] = r;
                size++;
            }
        }

    }

   public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {

                if (storage[i].getUuid().equals(uuid)) {
                    return storage[i];
                } else {
                    System.out.println("резюме не найдено в базе" + uuid);
                }
        }
        return null;
    }

    public void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i] != null && storage[i].getUuid().equals(uuid)) {
                storage[i] = storage[size - 1];
                storage[size - 1] = null;
                size--;
                break;
            } else {
                System.out.println("резюме не найдено в базе" + uuid);
                break;
            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public void update(Resume resume) {
        for (int i = 0; i < size; i++) {
           if (storage[i].equals(resume)) {
               storage[i] = resume;
               size++;
           } else {
               System.out.println("резюме нет в базе" + resume.getUuid());
           }
        }
    }
}
