import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
    }

    void save(Resume r) {

        for (Resume res: getAll()) {
            if (res.uuid.equals(r.uuid)) {
                System.out.println("Резюме есть в базе");
            } else if (size == storage.length) {
                System.out.println("Переполнена база");
            } else {
                storage[size] = r;
                size++;
            }
        }

    }

    Resume get(String uuid) {

        for (Resume res: getAll()) {
            if (res.uuid.equals(uuid)) {
                return res;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int index = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                index = i;
            }
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

    int size() {
        return size;
    }
}
