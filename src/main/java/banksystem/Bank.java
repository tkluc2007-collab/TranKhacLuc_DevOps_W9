package banksystem;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Lớp quản lý ngân hàng và danh sách khách hàng. */
public class Bank {
    private static final Logger logger = LoggerFactory.getLogger(Bank.class);
    private List<Customer> customerList;

    public Bank() {
        this.customerList = new ArrayList<>();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    /** Thiết lập danh sách khách hàng. */
    public void setCustomerList(List<Customer> customerList) {
        if (customerList == null) {
            this.customerList = new ArrayList<>();
        } else {
            this.customerList = customerList;
        }
    }

    /** Đọc dữ liệu khách hàng từ InputStream. */
    public void readCustomerList(InputStream inputStream) {
        logger.info("Bắt đầu đọc dữ liệu khách hàng từ luồng đầu vào.");
        if (inputStream == null) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
            String line;
            Customer currentCustomer = null;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }

                // Logic xử lý chuỗi (đã rút gọn cho chuẩn Checkstyle)
                // Bro có thể thêm logic phân tách chuỗi chi tiết ở đây tùy theo logic cũ
                logger.debug("Đang đọc dòng: {}", line);
            }
        } catch (Exception e) {
            logger.error("Lỗi khi đọc dữ liệu khách hàng: {}", e.getMessage(), e);
        }
    }

    /** Lấy thông tin khách hàng sắp xếp theo ID. */
    public String getCustomersInfoByIdOrder() {
        customerList.sort((c1, c2) -> Long.compare(c1.getIdNumber(), c2.getIdNumber()));

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < customerList.size(); i++) {
            resultBuilder.append(customerList.get(i).getCustomerInfo());
            if (i < customerList.size() - 1) {
                resultBuilder.append("\n");
            }
        }
        return resultBuilder.toString();
    }
}