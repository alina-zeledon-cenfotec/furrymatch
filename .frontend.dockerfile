#Build frontend image
FROM node:16 as build
WORKDIR /usr/local/app
COPY ./ /usr/local/app/
RUN npm install
RUN npm run build
FROM nginx:latest
COPY --from=build /usr/local/app/target/classes/static /usr/share/nginx/html
EXPOSE 9000