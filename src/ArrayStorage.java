import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    public ArrayStorage() {
    }

    void clear() {
        Resume[] var1 = this.storage;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            Resume resume = var1[var3];
            if (resume != null) {
                resume = null;
            }
        }

    }

    void save(Resume r) {
        Resume[] var2 = this.storage;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Resume resume = var2[var4];
            if (resume == null) {
                break;
            }

            if (!resume.equals(r)) {
                break;
            }
        }

    }

    Resume get(String uuid) {
        for(int i = 0; i < this.storage.length; ++i) {
            if (this.storage[i].uuid.equals(uuid)) {
                return this.storage[i];
            }
        }

        return null;
    }

    void delete(String uuid) {
        Resume[] var2 = this.storage;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Resume resume = var2[var4];
            if (resume.uuid.equals(uuid)) {
                resume = null;
                break;
            }
        }

    }

    Resume[] getAll() {
        return new Resume[]{this.storage[this.size()]};
    }

    int size() {
        return (int) Arrays.stream(this.storage).filter((v) -> {
            return v != null;
        }).count();
    }
}

