# Invoice Management Apps #

Aplikasi untuk mengelola invoice dan menyambungkan berbagai metode pembayaran

Metode pembayaran yang di support:

* Virtual Account Bank
  * BNI
  * Bank CMB
  * Bank BSI
* e-Wallet
  * OVO
  * Gopay
* QR Payment
  * QRIS

Tipe tagihan yang tersedia:

  * CLOSED: bayar sesuai nominal, kalau tidak sesuai ditolak
  * OPEN: pembayaran berapapun diterima
  * INSTALLMENT: pembayaran diterima selama total akumulasi lebih kecil atau sama dengan nilai tagihan

## Setup Database

1. PostgreSQL docker
  ```
  $ docker run -d --rm \
      --name invoice-db \
      -e POSTGRES_DB=invoice-db \
      -e POSTGRES_USER=invoice-user \
      -e POSTGRES_PASSWORD=DT92dPkjrK \
      -e PGDATA=/var/lib/postgresql/data/pgdata \
      -v {current-path}/invoicedb-data:/var/lib/postgresql/data \
      -p 54321:5432 \
      postgres:13
  ```

for UNIX
  ```
      -v $PWD/invoicedb-data:/var/lib/postgresql/data \
  ```

Run psql

  ```
  docker exec -it invoice-db bash
  psql -h 127.0.0.1 -U invoice-user invoice-db
  ```
