FROM ollama/ollama

# Install curl for checking server status
RUN apt-get update && apt-get install -y curl

# Copy the startup script
COPY entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

# Override the default ENTRYPOINT
ENTRYPOINT ["/entrypoint.sh"]
