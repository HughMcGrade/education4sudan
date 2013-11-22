class MessagesController < ApplicationController

  def index
    @staff = Staff.find(params[:id])
  end

  def show
    @message = Message.find(params[:id])
  end

end
