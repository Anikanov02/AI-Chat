#!/bin/bash

# Start the Ollama server in the background
ollama serve &

# Wait for the server to be ready
until curl -s http://localhost:11434/version >/dev/null; do
  echo "Waiting for Ollama to start..."
  sleep 1
done

# Load models
ollama run deepseek-coder:latest
ollama run deepseek-r1:latest
ollama run deepseek-v3:latest

# Keep container alive
wait
